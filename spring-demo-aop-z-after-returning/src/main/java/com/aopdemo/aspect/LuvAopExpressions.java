package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {

    @Pointcut("execution(* com.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {
    }

    @Pointcut("execution(* com.aopdemo.dao.*.get*(..))")
    public void getter() {
    }

    @Pointcut("execution(* com.aopdemo.dao.*.set*(..))")
    public void setter() {
    }

    //combine pointcut
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {
    }
}
