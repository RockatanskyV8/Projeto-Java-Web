package br.com.teste.models;

import java.sql.Date;
import java.util.Calendar;

public class Equipamento {
	  private int id;
	  private String name;
	  private String local;
	  private Calendar adquirido;
	
	  public void setId(int id){
	    this.id = id;
	  }
	
	  public void setName(String n){
	    this.name = n;
	  }
	  public void setLocal(String l){
	    this.local = l;
	  }
	  public void setAdquirido(Calendar adquirido2){
		    this.adquirido = adquirido2;
	  }
	
	  public int getId(){
	    return this.id;
	  }
	  public String getName(){
	    return this.name;
	  }
	  public String getLocal(){
	    return this.local;
	  }
	  public Calendar getAdquirido(){
		    return this.adquirido;
	  }
}
