package kr.or.ddit.vo;

import java.io.Serializable;

/**
 *  <자바 빈 규약>
 * VO(Value Object), DTO(dtata Transfer,object),Model,Bean
 *	1. 값을 저장할 수 있는 프로퍼티.
 *	2. 갭슐화
 *	3. 캡슐화된 프로퍼티에 한 인터페이스 제공.
 *	4. 상태 비교 방법 제공.
 *		==, equals(*)
 *	5. 상태 확인방법 제공.
 *	6. 직렬화 기능.
 */
public class BtsVO implements Serializable, Comparable<BtsVO>{
	private String code;
	private String name;
	private transient String path;
	private int count;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public BtsVO() {
		super();
	}

	public BtsVO(String code,String name,String path) {
		super();
		this.code=code;
		this.name=name;
		this.path=path;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BtsVO other = (BtsVO) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BtsVO [code=" + code + ", name=" + name + ", path=" + path + ", count=" + count + "]";
	}
	@Override
	public int compareTo(BtsVO o) {
		
		return -(this.count - o.getCount());
	}
	
	
	
	
	
	
	
	
	
}
