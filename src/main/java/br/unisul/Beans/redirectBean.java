package br.unisul.Beans;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
public class redirectBean{ 

   public void methodInManagedBean() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");//add your URL here, instead of list.do
   }
   }