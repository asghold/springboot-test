package com.test.trupper.springboot_test.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.test.trupper.springboot_test.entities.Cliente;
import com.test.trupper.springboot_test.entities.ListaCompra;
import com.test.trupper.springboot_test.entities.ListaCompraDetalle;
import com.test.trupper.springboot_test.entities.ListaCompraDetallePK;
import com.test.trupper.springboot_test.entities.Producto;
import com.test.trupper.springboot_test.model.ComprasDto;
import com.test.trupper.springboot_test.model.DetalleDto;
import com.test.trupper.springboot_test.repository.ClienteRepository;
import com.test.trupper.springboot_test.repository.ListaCompraDetalleRepository;
import com.test.trupper.springboot_test.repository.ListaComprasRepository;
import com.test.trupper.springboot_test.repository.ProductoRepository;
import com.test.trupper.springboot_test.service.ComprasService;

@Service
public class ComprasServiceImpl implements ComprasService{

    @Autowired
    private ListaComprasRepository listaComprasRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ListaCompraDetalleRepository listaCompraDetalleRepository;

    @Override
    public ComprasDto resistraCompra(ComprasDto comprasDto) throws NotFoundException{
        try{
            ListaCompra listaCompra = new ListaCompra();
            List<ListaCompraDetalle> listaCompraDetalles = new ArrayList<>();
            if(comprasDto != null){
                Cliente cliente = clienteRepository.findById(comprasDto.getCliente()).orElse(null);
                if(cliente == null){
                    cliente = new Cliente();
                    cliente.setActivo(true);
                    cliente.setIdCliente(comprasDto.getCliente());
                    cliente.setNombre("Cliente_"+comprasDto.getCliente());
                    clienteRepository.save(cliente);
                }
                listaCompra.setCliente(cliente);
                for(DetalleDto detalleDto : comprasDto.getDetalle()){
                    Producto producto = productoRepository.findById(detalleDto.getIdProducto()).orElse(null);
                    if(producto== null){
                        producto = new Producto();
                        producto.setActivo(true);
                        producto.setClave("P_"+detalleDto.getIdProducto());
                        producto.setIdProducto(detalleDto.getIdProducto());
                        producto.setDescripcion("Descripcion_producto");
                        productoRepository.save(producto);
                    }
                    ListaCompraDetalle lista = new ListaCompraDetalle();
                    lista.setCantidad(detalleDto.getCantidad());
                    lista.setProducto(producto);
                    
                    listaCompraDetalles.add(lista);
                    
                }
                listaCompra.setListaCompraDetalles(listaCompraDetalles);
                listaCompra.setActivo(true);
                Date fecha = new Date();
                listaCompra.setFechaRegistro(fecha);
                listaCompra.setFechaUltimaActualizacion(fecha);
                listaCompra.setNombre(comprasDto.getNombreLista());
                
                listaComprasRepository.save(listaCompra);
                listaCompra = listaComprasRepository.findByFechaRegistro(listaCompra.getFechaRegistro());
                for(ListaCompraDetalle lista: listaCompra.getListaCompraDetalles()){
                    ListaCompraDetallePK id = new ListaCompraDetallePK();
                    id.setCodigoProducto(lista.getProducto().getIdProducto());

                    id.setIdListaCompra(listaCompra.getIdLista());
                    lista.setListaCompra(listaCompra);

                    lista.setId(id);
                    listaCompraDetalleRepository.save(lista);
                }
            }
            return comprasDto;

        }catch (Exception e){
            throw new UnsupportedOperationException("No fue posible persistir la lista de compras");
        }        
    }

    @Override
    public List<ComprasDto> obtenerCompras(Integer idCliente) throws NotFoundException{
        try{
            Cliente cliente = clienteRepository.findById(idCliente).orElse(null);
            List<ComprasDto> listaCompras = new ArrayList<>();
            if(cliente != null){
                List<ListaCompra> compras = listaComprasRepository.findByCliente(cliente);
                for(ListaCompra compra : compras){
                    List<DetalleDto> detalles = compra.getListaCompraDetalles().stream().map(detalle ->{
                        return DetalleDto.builder()
                        .idProducto(detalle.getProducto().getIdProducto())
                        .cantidad(detalle.getCantidad()).build();
                    }).collect(Collectors.toList());
                    ComprasDto comprasDto = new ComprasDto(compra.getCliente().getIdCliente(), compra.getNombre(), detalles);
                    listaCompras.add(comprasDto);
                }

            }else {
                throw new NotFoundException();    
            }
            return listaCompras;

        }catch(Exception e){
            throw new NotFoundException(); 
        }
    }

    @Override
    public ComprasDto actualizaCompras(Integer id, List<DetalleDto> detalleDto) {
        try{
            Cliente cliente = clienteRepository.findById(id).orElse(null);
            if(cliente != null && cliente.getListaCompras().size()==1){
                ListaCompra listaCompra = cliente.getListaCompras().get(0);
                listaCompra.setNombre("Lista Actualizada");
                List<ListaCompraDetalle> listDetalle = listaCompra.getListaCompraDetalles();
                for(DetalleDto detalleDto2 : detalleDto){
                    ListaCompraDetalle listaDetalle = new ListaCompraDetalle();
                    listaDetalle.setCantidad(detalleDto2.getCantidad());
                    listaDetalle.setListaCompra(listaCompra);
                    Producto producto = productoRepository.findById(detalleDto2.getIdProducto()).orElse(null);
                    if(producto== null){
                        producto = new Producto();
                        producto.setActivo(true);
                        producto.setClave("P_"+detalleDto2.getIdProducto());
                        producto.setIdProducto(detalleDto2.getIdProducto());
                        producto.setDescripcion("Descripcion_producto");
                        productoRepository.save(producto);
                    }
                    listaDetalle.setProducto(producto);
                    ListaCompraDetallePK detallePK = new ListaCompraDetallePK();
                    detallePK.setCodigoProducto(producto.getIdProducto());
                    detallePK.setIdListaCompra(listaCompra.getIdLista());
                    listaDetalle.setId(detallePK);
                    listaCompraDetalleRepository.save(listaDetalle);
                    listDetalle.add(listaDetalle);
                    
                }
                
                listaCompra.setListaCompraDetalles(listDetalle);
                listaCompra.setFechaUltimaActualizacion(new Date());
                listaComprasRepository.save(listaCompra);
                List<DetalleDto> detalles = listDetalle.stream().map(detalle -> {
                    return DetalleDto.builder()
                        .cantidad(detalle.getCantidad())
                        .idProducto(detalle.getProducto().getIdProducto())
                        .build();  
                }).collect(Collectors.toList());
                detalles.addAll(detalleDto);
            
                return new ComprasDto(id, listaCompra.getNombre(), detalles);
            }else {
                throw new UnsupportedOperationException("Unimplemented method 'actualizaCompras'");
            }

        }catch(Exception e){
            e.printStackTrace();
            throw new UnsupportedOperationException("Unimplemented method 'actualizaCompras'");
        }
    }

    @Override
    public void eliminaCompra(Integer id) throws NotFoundException {
        try{
            ListaCompra listaCompra = listaComprasRepository.findById(id).orElse(null);
            if(listaCompra!= null){
                listaCompra.getListaCompraDetalles().forEach(detalle -> {
                    listaCompraDetalleRepository.delete(detalle);
                });
                listaComprasRepository.delete(listaCompra);
            }else {
                throw new NotFoundException();    
            }
        } catch (Exception e){
            throw new NotFoundException();
        }
    }



}
