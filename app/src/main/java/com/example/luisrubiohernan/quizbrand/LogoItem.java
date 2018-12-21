package com.example.luisrubiohernan.quizbrand;

public class LogoItem {
    private String random_letter;   //Letras colocadas aleatoriamente
    private String answer;//Respuesta real
    private int score;
    private boolean answered;       //si ha sido contestada la pregunta correctamente

    public LogoItem(String answer) {
        this.answer = answer;
        this.answered = false;
        this.score=score;
    }

    public LogoItem(String random_letter, String answer) {
        this.random_letter = random_letter;
        this.answer = answer;
    }

    public LogoItem(String random_letter, String answer, int score){
        this.random_letter = random_letter;
        this.answer = answer;
        this.score=score;
        this.answered = answered;
    }

    public String getRandom_letter(){
        return random_letter;
    }

    public String getAnswer(){
        return answer;
    }

    public int getScore(){
        return score;
    }

    public boolean getAnswered(){
        return answered;
    }

    public void setRandom_letter(){
        this.random_letter=random_letter;
    }

    public void setAnswer(){
        this.answer=answer;
    }

    public void setScore(){
        this.score=score;
    }

    public void setAnswered(){
        this.answered=answered;
    }

    public void setAlreadyAnswered(){
        this.answered=!this.answered;
    }

    public void setNewScore(){

        if (score>1){
            this.score=score-1;
        }else {
            this.score=score;
        }
    }

}
