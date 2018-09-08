package com.sp.entity;

public class Line2 {
    private String gid;
    private String us_id;
    private String ds_id;
    private String material;
    private String diameter;
    private String feature_P;
    private String appendant;
    private float us_x;
    private float us_y;
    private float ds_x;
    private float ds_y;
    private float us_el;
    
    private String type;
    private String is_;
    private String geom;
    
    
    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIs_() {
		return is_;
	}

	public void setIs_(String is_) {
		this.is_ = is_;
	}

	public String getGeom() {
		return geom;
	}

	public void setGeom(String geom) {
		this.geom = geom;
	}

	public float getUs_el() {
		return us_el;
	}

	public void setUs_el(float us_el) {
		this.us_el = us_el;
	}

	public float getUs_il() {
		return us_il;
	}

	public void setUs_il(float us_il) {
		this.us_il = us_il;
	}

	public float getUs_dept() {
		return us_dept;
	}

	public void setUs_dept(float us_dept) {
		this.us_dept = us_dept;
	}

	public float getDs_el() {
		return ds_el;
	}

	public void setDs_el(float ds_el) {
		this.ds_el = ds_el;
	}

	public float getDs_il() {
		return ds_il;
	}

	public void setDs_il(float ds_il) {
		this.ds_il = ds_il;
	}

	public float getDs_dept() {
		return ds_dept;
	}

	public void setDs_dept(float ds_dept) {
		this.ds_dept = ds_dept;
	}

	public String getBlocking() {
		return blocking;
	}

	public void setBlocking(String blocking) {
		this.blocking = blocking;
	}

	private float us_il;
    private float us_dept;
    private float ds_el;
    private float ds_il;
    private float ds_dept;
    private String blocking;
    
    public String getFeature_P() {
		return feature_P;
	}

	public void setFeature_P(String feature_P) {
		this.feature_P = feature_P;
	}

	public Line2() {
        super();
    }

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getUs_id() {
		return us_id;
	}

	public void setUs_id(String us_id) {
		this.us_id = us_id;
	}

	public String getDs_id() {
		return ds_id;
	}

	public void setDs_id(String ds_id) {
		this.ds_id = ds_id;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getDiameter() {
		return diameter;
	}

	public void setDiameter(String diameter) {
		this.diameter = diameter;
	}



	public String getAppendant() {
		return appendant;
	}

	public void setAppendant(String appendant) {
		this.appendant = appendant;
	}

	public float getUs_x() {
		return us_x;
	}

	public void setUs_x(float us_x) {
		this.us_x = us_x;
	}

	public float getUs_y() {
		return us_y;
	}

	public void setUs_y(float us_y) {
		this.us_y = us_y;
	}

	public float getDs_x() {
		return ds_x;
	}

	public void setDs_x(float ds_x) {
		this.ds_x = ds_x;
	}

	public float getDs_y() {
		return ds_y;
	}

	public void setDs_y(float ds_y) {
		this.ds_y = ds_y;
	}
    
}