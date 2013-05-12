package com.rcarrillocruz.android.openstackdroid;

public class TenantModel {
	private String id;
	private String name;
	private boolean enabled;
	private String description;
	
	public TenantModel(String id, String name, boolean enabled,
			String description) {
		super();
		this.id = id;
		this.name = name;
		this.enabled = enabled;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String toString() {
		return this.name;
	}
}
