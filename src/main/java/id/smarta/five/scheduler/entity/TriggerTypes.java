package id.smarta.five.scheduler.entity;

public enum TriggerTypes {
	
	CRON("CRON"), Simple("SIMPLE");
	
	private String code;

	private TriggerTypes(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

}
