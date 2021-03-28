/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.annalauton.jakartaee8.atividadeavaliativa;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ResourceBundle;
import javax.faces.application.Application;
import javax.faces.context.FacesContext;

@Named(value = "quiz5Bean")
@SessionScoped
public class Quiz5Bean implements Serializable {

    private String guess;

    
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">

    public String getGuess() {
        return guess;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }
    
    //</editor-fold>

    public String getResponse() {
        // Recupera contexto da aplicação
        FacesContext context = FacesContext.getCurrentInstance();
        Application application = context.getApplication();

        // Recupera fonte de recursos para internacionalização
        ResourceBundle resourceBundle = application.getResourceBundle(context, "i18n");

        if (guess.equals("q5o1")) {
            // Recupera e devolve resposta de sucesso
            return resourceBundle.getString("response.success");
        } else {
            // Recupera e devolve resposta de falha
            return resourceBundle.getString("response.fail");
        }
    }
    
    
}
