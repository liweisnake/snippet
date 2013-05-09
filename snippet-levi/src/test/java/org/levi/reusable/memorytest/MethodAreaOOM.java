package org.levi.reusable.memorytest;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodProxy;

public class MethodAreaOOM {
	
	public static void main(String [] args){
		while(true){
			Enhancer enhancer = new Enhancer();
			enhancer.setSuperclass(OOMObject.class);
			enhancer.setUseCache(false);
			enhancer.setCallback(new org.springframework.cglib.proxy.MethodInterceptor() {
				
				@Override
				public Object intercept(Object arg0, Method arg1, Object[] arg2,
						MethodProxy arg3) throws Throwable {
					return arg3.invokeSuper(arg0, arg2);
				}
			});
			enhancer.create();
		}
	}
	
	static class OOMObject{
		
	}

}
