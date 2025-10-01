package com.example.bemestar_api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "checkins")
public class CheckIn {

    @Id
    private String id;
    private String usuario;
    private String sintoma;
    private String data;

    public CheckIn() {}

    public CheckIn(String usuario, String sintoma, String data) {
        this.usuario = usuario;
        this.sintoma = sintoma;
        this.data = data;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    public String getSintoma() { return sintoma; }
    public void setSintoma(String sintoma) { this.sintoma = sintoma; }

    public String getData() { return data; }
    public void setData(String data) { this.data = data; }
}
