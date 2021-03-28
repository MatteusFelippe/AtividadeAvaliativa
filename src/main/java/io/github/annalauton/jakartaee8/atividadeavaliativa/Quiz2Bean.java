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

@Named(value = "quiz2Bean")
@SessionScoped
public class Quiz2Bean implements Serializable {

    private final Integer resposta;
    private final Integer minimum;
    private final Integer maximum;
    private Integer guess;
    private boolean[] disabled;

    public Quiz2Bean() {
        resposta = 10;
        minimum = 0;
        maximum = 10000;
        // Default state for all guess buttons: false
        disabled = new boolean[maximum - minimum + 1];
    }

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Integer getResposta() {
        return resposta;
    }

    public Integer getGuess() {
        return guess;
    }

    public void setGuess(Integer guess) {
        disabled[guess - minimum] = true;
        this.guess = guess;
    }

    public Integer getMinimum() {
        return minimum;
    }

    public Integer getMaximum() {
        return maximum;
    }

    public boolean[] getDisabled() {
        return disabled;
    }

    public void setDisabled(boolean[] disabled) {
        this.disabled = disabled;
    }

    //</editor-fold>
    public String getResponse() {
        // Recupera contexto da aplicação
        FacesContext context = FacesContext.getCurrentInstance();
        Application application = context.getApplication();

        // Recupera fonte de recursos para internacionalização
        ResourceBundle resourceBundle = application.getResourceBundle(context, "i18n");

        if (resposta.equals(guess)) {
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            // Recupera e devolve resposta de sucesso
            return resourceBundle.getString("response.success");
        } else {
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            // Recupera e devolve resposta de falha
            return resourceBundle.getString("response.fail");
        }
    }

}
