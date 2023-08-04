#Workout App

**Workout Planner**

An app that keeps can be used to design your own workout routine as well as keep track of
current workout. 

A *bulleted* list:
- **What will Application do?**

*This application is intended to allow user to create their own workout routine 
by making exercises which include a name, number of sets, and number of reps. They can also add
exercises to a specific muscle group, and they can access all the exercises that are
included for a muscle group and do various operations on them such as editing, adding, and removing an exercise 
from muscle group. 
Users can create their workout session by adding entire muscle groups to their session
or they can add individual exercises as well. This app also allows them preview their workout by printing out the 
current exercise, allowing 
them to edit their session accordingly if it is too hard or too easy. The main feature of this app is that it 
allows users
to track their workout with a press of a button as it prints out the next exercise in their session when they are 
finished the current exercise. 

- **Who will use it?**

*This app is intended for those that workout and want an app that they can use to 
track their workout and create their own training session. This is very convenient because while people
workout they have a hard time keeping track of which exercises they want to do and how many sets and reps they
got to do. 
This app will allow users to never forget an exercise and will assist them in achieving great results when working out 
and stay consistent.*

- **Why is this project of interest to you?**

*This project interests me because I workout, and sometimes struggle to remember and keep track of
my routine and might miss an exercise so having an app that I can use to track and plan my workouts is ideal and makes 
working out a lot more convenient.*

**User Story**

- As a user, I want to be able to create a new exercise and choose the amount of sets and reps and add it to a 
muscle group
- As a user, I want to be able to add an exercise or an entire muscle group to my training session
- As a user, I want to be able to edit the number of sets and reps of exercises 
- As a user, I want to be able to view a list of all exercises I am doing in current session,
along with the sets and reps.
- As a user, I want to be able to track my training session, exercise by exercise.
- As a user, I want to be able to remove exercises from muscle groups.
- As a user, I want to be able to remove exercises from my training session.
- As a user, I want to be able to save my created muscle groups
- As a user, I want to be able to load my created muscle groups
- As a user, I want to be able to have a quit option for my menu

**Phase 4: Task 2**

Fri Apr 01 00:47:51 PDT 2022
Added Chest Press to Chest


Fri Apr 01 00:48:05 PDT 2022
Changed Chest Press's sets to 4 and reps to 3


Fri Apr 01 00:48:14 PDT 2022
Removed Chest Press from Chest


Fri Apr 01 00:48:19 PDT 2022
Loaded Karn's Workout from ./data/workouts.json


Fri Apr 01 00:48:27 PDT 2022
Added Wide-grip Pull-ups to session


Fri Apr 01 00:48:27 PDT 2022
Added Barbell Rows to session


Fri Apr 01 00:48:27 PDT 2022
Added Angel & Devil to session


Fri Apr 01 00:48:27 PDT 2022
Added Deadlifts to session


Fri Apr 01 00:48:36 PDT 2022
Removed Deadlifts from session


Fri Apr 01 00:48:42 PDT 2022
Added Dips to session


Fri Apr 01 00:48:42 PDT 2022
Added Close-grip Push-ups to session


Fri Apr 01 00:48:42 PDT 2022
Added Tricep Press to session


Fri Apr 01 00:48:58 PDT 2022
Added Side Raise to session


Fri Apr 01 00:49:11 PDT 2022
Removed Leg Press from Legs


Fri Apr 01 00:49:20 PDT 2022
Added Leg Raise to Legs


Fri Apr 01 00:49:28 PDT 2022
Changed Leg Raise's sets to 3 and reps to 10


Fri Apr 01 00:49:32 PDT 2022
Finished Exercise Wide-grip Pull-ups


Fri Apr 01 00:49:33 PDT 2022
Finished Exercise Barbell Rows


Fri Apr 01 00:49:33 PDT 2022
Finished Exercise Angel & Devil


Fri Apr 01 00:49:33 PDT 2022
Finished Exercise Dips


Fri Apr 01 00:49:34 PDT 2022
Finished Exercise Close-grip Push-ups


Fri Apr 01 00:49:34 PDT 2022
Finished Exercise Tricep Press


Fri Apr 01 00:49:34 PDT 2022
Finished Exercise Side Raise


**Phase 4: Task 3**
- My design has around 48 different panels and I have a class called EastPanelManager which decides which panel
will be displayed in the East panel and I wish I could find a way to reduce the amount of panels I have by perhaps 
using fewer panels and having a field for a state which decides how the panel appears based on the state, rather than
having a panel for each task I want to carry out because this would simplify the design significantly. 
- In my design I have to update panels whenever I add an exercise to a workout or to a session and when I do this, 
I update the panel by deleting it and reinitializing it. I wasn't sure how to update the panel without deleting it and 
couldn't find a way to do that so if I could figure out how to update the current panel, I would definitely incorporate 
that into my design.
- I think there would be more ways to improve my program but based on the knowledge I've gained over this course,
I have simplified my code as much as possible and have a decent design because most of the UI is dependent on one 
particular class which manages the panel so if anything goes wrong with UI, I can easily identify source of error. 
I learned this process of design through the CPSC 210 lecture on UML diagrams and knowledge on good design habits, 
will help me throughout my career in software design. 
