package org.levi.reusable.compiler;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;

public class DynamicCompilerTest {
	
	private static final String className = "TestCaculate";
	
	private static final String methodName = "caculate";

	public static void main(String[] args) throws Exception {
		
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager fileManager = compiler.getStandardFileManager(
				null, null, null);
        File[] outputs = new File[]{new File("target/classes/")};
		try {
			fileManager.setLocation(StandardLocation.CLASS_OUTPUT, Arrays.asList(outputs));
		} catch (IOException e) {
			e.printStackTrace();
		}

//fileManager.getFileForOutput(location, packageName, relativeName, sibling)
		Iterable<? extends JavaFileObject> fileObjects = Arrays
				.asList(getStringSource(args[0]));
		CompilationTask task = compiler.getTask(null, fileManager, null, null,
				null, fileObjects);
		boolean result = task.call();
		if (result) {
			System.out.println("编译成功。");
			ClassLoader classLoader = DynamicCompilerTest.class.getClassLoader();
			Class clazz = classLoader.loadClass(className);
			Method method = clazz.getMethod(methodName, null);
			Object value = method.invoke(null, null);
			System.out.println(value);
		}
		fileManager.close();
		
	}
	
	private static StringSourceJavaObject getStringSource(String expr) throws URISyntaxException{
		return new DynamicCompilerTest.StringSourceJavaObject(className, "public class " + className + " { public static double " + methodName + "() {return " + expr + ";} }");
	}

	static class StringSourceJavaObject extends SimpleJavaFileObject {
		private String content = null;

		public StringSourceJavaObject(String name, String content)
				throws URISyntaxException {
			super(URI.create("string:///" + name.replace('.', '/')
					+ Kind.SOURCE.extension), Kind.SOURCE);
			this.content = content;
		}

		public CharSequence getCharContent(boolean ignoreEncodingErrors)
				throws IOException {
			return content;
		}
	}
}
