package controllers;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

@ManagedBean
@ViewScoped
public class MyBean implements Serializable {

    private String page;

    @PostConstruct
    public void init() {
        page = "test1";
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}
