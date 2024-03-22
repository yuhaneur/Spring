package kr.or.ddit.servlet09;

import java.io.File;
import java.io.Serializable;

public class FileWrapper implements Serializable, Comparable<FileWrapper>{
	private File adaptee;

	public FileWrapper(File adaptee,String path) {
		super();
		this.adaptee = adaptee;
		this.path = path;
	}
	
	private String path;
	
	public String getPath() {
		return path;
	}
	
	public String getName() {
		return adaptee.getName();
	}
	
	public boolean isFile() {
		return adaptee.isFile();
	}
	
	public boolean isFolder() {
		return adaptee.isDirectory();
	}

	@Override
	public int compareTo(FileWrapper o) {
		if(isFile() ^ o.isFile()) { // 피연산자가 하나는 true이고 다른 하나가 false일 경우에만 연산 결과가 true
			return isFolder() ? -1 : 1;
		}else {
			return this.adaptee.getName().toLowerCase().compareTo(o.getName().toLowerCase());
		}
	}
}
