# WI-QUIZ-TIME
UML LINK:
https://lucid.app/lucidchart/ada89605-6805-4dfe-852a-10997e466a84/edit?viewport_loc=-1088%2C-532%2C4033%2C1840%2C0_0&invitationId=inv_8066f568-2b73-40d9-8a9b-a513df2c5333


## Api documentation
### Level
endpoint| method | payload | description
-|--------|-|-
/level| `POST` |`{description:string, maxScore: int, minScore: int}`| create a level
/level/{id}| `GET`  | `-` | find level by id
/level/{id}| `PUT`  | `{description:string, maxScore: int, minScore: int}` | edit a level
/level/{id}/questions | `GET` | `-` | get questions of a specific level
/level| `GET` | `-` | get all levels

### Subject
endpoint| method | payload                          | description
-|--------|----------------------------------|-
/level| `POST` | `{title:string, parend_id: int}` | create a subject
/subject/{id}| `GET`  | `-`                              | find subject by id
/subject/{id}| `PUT`  | `{title:string, parent_id: int}` | edit a subject
/subject/{id}/questions | `GET` | `-`                              | get questions of a specific subject
/level| `GET` | `-`                              | get all subjects

### Question
endpoint| method | payload                                                                                                                                                                        | description                         
-|-------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------
/question| `POST` | `{responseNbr:int, correctResponseNbr: int, questionText: string, type: string, totalScore: double, subject_id: int, level_id: int, medias: Array{name:string, type: string}}` | create a question                   
/question/{id}| `GET` | `-`                                                                                                                                                                            | find question by id                 
/question/{id}| `PUT` | `{responseNbr:int, correctResponseNbr: int, questionText: string, type: string, totalScore: double, subject_id: int, level_id: int, medias: Array{name:string, type: string}}`| edit question                      
/question/{id}/medias | `GET` | `-`                                                                                                                                                                            | get medias of a specific media 
/question| `GET` | `-`                                                                                                                                                                            | get all questions
/question/{id}/responses| `GET` | `-`| find response of question
/question/{id} | `DELETE` | `-` | delete question by id

### Quiz
endpoint | method | payload                                                                                                                                                     | description
-| - |-------------------------------------------------------------------------------------------------------------------------------------------------------------| - 
/quizz | `POST` | `{score: double, showAnswers: double, showFinalResults: boolean, chanceNbr: int, durationInMinutes: int, remark: string, teacher_id: int, subject_id: int}` | create a quiz
/quizz | `GET` | `-`                                                                                                                                                         | final all quizzes
/quiz/{id} | `GET` | `-`                                                                                                                                                         | final specific id |
/quiz/{id} | `PUT` | `{score: double, showAnswers: double, showFinalResults: boolean, chanceNbr: int, durationInMinutes: int, remark: string, teacher_id: int, subject_id: int}` | edit specific quiz
/quiz/{id} | `DELETE` | `-`                                                                                                                                                         | delete a specific quiz

### Response

endpoint | method | payload                                                                                                                                                     | description
 -| - |-------------------------------------------------------------------------------------------------------------------------------------------------------------| - 
  /response | `POST` | `{response: int, point: double, question_id: int}` | create a response and assigned to a question
  /response/{id} | `PUT` | `{response: int, point: double, question_id: int}` | edit a specific response
  /response/{id} | `GET` | `-` | find a speicifc response by id

### Student

endpoint | method | payload                                                                                                                                                     | description
-| - |-------------------------------------------------------------------------------------------------------------------------------------------------------------| - 
/student | `POST` | `{firstName: string, lastName: string, birthday: localDate, address: string, dateOfInscription: localDate}` | create a student
/student | `GET` | `-` | get all students
/student/{id} | `GET` | `-` | get a specific student by id
/student/{id} | `PUT` | `{firstName: string, lastName: string, birthday: localDate, address: string, dateOfInscription: localDate}` | edit a specific student
/student/{id} | `DELETE` | `-` | delete a specific student

### Trainer
endpoint | method | payload                                                                                                                                                     | description
-| - |-------------------------------------------------------------------------------------------------------------------------------------------------------------| - 
/teacher | `POST` | `{firstName: string, lastName: string, birthday: localDate, address: string, role: string}` | create a teacher
/teacher | `GET` | `-`                                                                                         | get all teachers
/teacher/{id} | `GET` | `-`                                                                                         | get a specific teacher by id
/teacher/{id} | `PUT` | `{firstName: string, lastName: string, birthday: localDate, address: string, role: string}` | edit a specific teacher
/teacher/{id} | `DELETE` | `-`                                                                                         | delete a specific teacher

### AssignQuiz

endpoint | method | payload                                                                                                                                                     | description
-| - |-------------------------------------------------------------------------------------------------------------------------------------------------------------| - 
/assignQuiz | `POST` | `[{score: double, played: int, reason: string, result: string, debutDate: localDateTime, endDate: localDateTime, student_id: int, quiz_id: int}]` | create an assignquiz for one or multiple student
/assignQuiz | `GET` | `-` | get all assignedQuiz
/assignQuiz/{id} | `GET` | `-` | get specific assigned quiz
/assignQuiz/{id} | `PUT` | `{score: double, played: int, reason: string, result: string, debutDate: localDateTime, endDate: localDateTime, student_id: int, quiz_id: int}` | update a specific assigned quiz
/assignQuiz/{id} | `DELELTE` | `-` | delete a specific quiz