package com.test.trupper.springboot_test.aspectos;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MedirTiempoEjecucion {

    @Around("execution(* com.test.trupper.springboot_test.*.*())")
    public void tiempo(ProceedingJoinPoint point) throws Throwable {
        Long tiempoInicio = System.currentTimeMillis();
        point.proceed();
        Long tiempoFin = System.currentTimeMillis();
        Long total = tiempoFin - tiempoInicio;
        if (total >= 2000){
            System.out.format("El servicio es : %s y el tiempo transcurrido %d\n", point.getSignature().getName(), total);
        }
 
    }
}
