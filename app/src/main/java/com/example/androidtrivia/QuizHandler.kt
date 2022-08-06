package com.example.androidtrivia

object QuizHandler {
    fun getQuestions(): ArrayList<Question> {
        return arrayListOf(
            Question(
                "What is the record for red cards given in a single soccer game?",
                "24",
                "12",
                "6",
                "36",
                "36"
            ),
            Question(
                "Which two countries participated in the first international soccer match?",
                "Scotland vs England",
                "Spain vs France",
                "Spain vs England",
                "England vs Portugal",
                "Scotland vs England"
            ),
            Question(
                "What was the largest margin of victory in an international soccer match?",
                "3",
                "12",
                "33",
                "31",
                "31"
            ),
            Question(
                "Who was the first player to score at five World Cup editions?",
                "Messi",
                "Maradona",
                "Ronaldo",
                "Pele",
                "Pele"
            ),
            Question(
                "What is a soccer field called?",
                "Court",
                "Pitch",
                "Paddock",
                "Box",
                "Pitch"
            ),
            Question(
                "How old was the youngest professional soccer player?",
                "18",
                "16",
                "12",
                "14",
                "12"
            )
        )
    }

}