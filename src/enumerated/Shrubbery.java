package enumerated;

public enum Shrubbery {
	GROUND("xxx"), GRAWLING("xxx"), HANGING("xxx");
	private String description;

	private Shrubbery(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
