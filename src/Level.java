
public class Level {
	private String name;
	private String length;
	Level(String name, String length) {
		this.name = name;
		this.length = length;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
}
