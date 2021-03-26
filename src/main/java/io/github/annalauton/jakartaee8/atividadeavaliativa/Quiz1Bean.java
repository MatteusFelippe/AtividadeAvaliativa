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

@Named(value = "quiz1Bean")
@SessionScoped
public class Quiz1Bean implements Serializable {

    private String guess;

    public String getGuess() {
        return guess;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }

    public String getResponse() {
        // Recupera contexto da aplicação
        FacesContext context = FacesContext.getCurrentInstance();
        Application application = context.getApplication();

        // Recupera fonte de recursos para internacionalização
        ResourceBundle resourceBundle = application.getResourceBundle(context, "i18n");

        if (resourceBundle.getString("resposta1").equals(guess.toLowerCase())) {
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            // Recupera e devolve resposta de sucesso
            return resourceBundle.getString("response.success");
        } else {
            // Recupera e devolve resposta de falha
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            return resourceBundle.getString("response.fail");
        }
    }
}
