package kr.or.ddit.instance;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import kr.or.ddit.reflection.obj.DabakBungeoppangzip;

/**
 * ClassA instenceA = new ClassA();
 * ClassA instenceB = new ClassA();
 * 데이터영역중 메소드 영역에서 constantpool 에는 int 가 저장됨
 * jvm이 하는일 
 * 1. ClassLoader 가 ClassA.class 파일을 클래스 패스에서 검색하고,
 * 해당 클래스 정보를 메모리에 저장함.
 * 2. 1번 단계에서 저장된 클래스 정보를 기반으로 인스턴스를 생성하고, 메모리에 저장함.
 * 3. 2번 단계에서 생성하고 저장된 인스턴스의 참조주소를 instanceA 라는 변수에 저장함.  
 *
 *	리플렉션이란 ? 
 *	 : 일반적인 객체 생성과정을 거치지 않고 회득한 인스턴스를 태상으로, 
 *	   해당 인스턴스의 타입(클래스), 상태정보(프로퍼티), 행동정보(메소드)를 찾아가는 작업.
 *    java.reflect 패캐지의 API가 지원됨.
 */
public class ReflectionDesc {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IntrospectionException, IllegalArgumentException, InvocationTargetException {
		Object instance = DabakBungeoppangzip.buyBungeoppang();
		System.out.println("instance : "+ instance);
		Class instanceType = instance.getClass();
		System.out.printf("%s\n",instanceType.getName());
		
		System.out.println("===========================상태정보 리플렉션============================");
		//리플랙션을 이용한 상태정보 찾기
		Field[] fields =  instanceType.getDeclaredFields();
		for(Field fld : fields) {
			String modifiers = Modifier.toString(fld.getModifiers()); // 접근제어자 ,스태틱여부 ,파이널여부 정보가져오애(겟모디파이어)
			Class fldType = fld.getType();
			String fldName = fld.getName();
			System.out.printf("%s %s %s;\n",modifiers,fldType.getSimpleName(),fldName);
		}
		// 자바빈에 따라 만들어진 필드는 프로퍼티라고 불림 아니면 필드라고 불림
		System.out.println("===========================행동정보 리플렉션============================");
		//리플랙션을 이용한 행동정보 찾기
		Method[] methods =  instanceType.getDeclaredMethods();
		for(Method mtd : methods) {
			String modifiers = Modifier.toString(mtd.getModifiers()); // 접근제어자 ,스태틱여부 ,파이널여부 정보가져오애(겟모디파이어)
			Class returnType = mtd.getReturnType();
			String mtdName = mtd.getName();
			Class[] paramTypes =mtd.getParameterTypes();
			System.out.printf("%s %s %s(%s);\n",
					modifiers,returnType.getSimpleName(),mtdName,Arrays.toString(paramTypes));
		}
		
		System.out.println("===========================프로퍼티정보 리플렉션============================");
		Object newBungeoppang = instanceType.newInstance();
		for(Field fld : fields) {
			String fldName = fld.getName();
			try {
				// 프로퍼티가 맞을꺼야 라고 생각하고 실행 프로퍼티가 아니면 예외 처리로 넘어감
				PropertyDescriptor pd = new PropertyDescriptor(fldName, instanceType);
				Method getter = pd.getReadMethod();
				Method setter = pd.getWriteMethod();
				Object value = getter.invoke(instance);
				setter.invoke(newBungeoppang, value);
				System.out.printf("%s = %s;\n",fldName,value);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println(newBungeoppang);
		PropertyDescriptor pd1 = new PropertyDescriptor("fishType",instanceType);
		pd1.getWriteMethod().invoke(newBungeoppang, "붕어");
		PropertyDescriptor pd2 = new PropertyDescriptor("ppangso",instanceType);
		pd2.getWriteMethod().invoke(newBungeoppang, "슈크림");
		System.out.println(newBungeoppang);
	}
}
