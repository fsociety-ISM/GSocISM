# Project Description:

## Overview:
- GSoc-ISM (i.e., Grievances SOCiety of IIT(ISM) Dhanbad) is a user-friendly platform for the administration to view & resolve the problems (petitions) posted by the students.
- This application allows its users to check real time status of the petitions filed regarding any academic or non-academic issue that the individual is facing. At the same time, it also enables the admin (college administration) to respond on the petition uploaded by the user and update the status of the petition in the order:
  PENDING -> IN PROGRESS -> RESOLVED 
- We are also working on a ‘Security Alert’ feature which enables the user to send a distress signal whenever the individual faces some kind of threat. Using this feature, the user can notify others (students & college administration) about the same by sending their current location with the help of the app and thus, ensure their safety on and off the college campus!
- Overall, GSocISM provides a more efficient process to deal with our day-to-day problems on campus and makes the process of dealing with such grievances much simpler.

## Specifications:
1. The app begins with the introductory page shown below, which allows the user to enter as an 'Admin' (for college administration only) or as a 'student':
<img width="100" alt="image" src="https://github.com/shubhranshu-animesh/GSocISM/assets/77923668/f7889f55-0b9d-4083-9b16-bf86114bba86">

2. Users who enter as students have their own login and sign-up options. Students are allowed to sign-up using the institute e-mail id only (with domain @deptName.iitism.ac.in).
<img width="100" alt="image" src="https://github.com/shubhranshu-animesh/GSocISM/assets/77923668/3e7505c0-215d-4e23-81f3-5eb4b418d670">
<img width="100" alt="image" src="https://github.com/shubhranshu-animesh/GSocISM/assets/77923668/9449adcd-854f-48fc-8d72-2f29e66159b5">
<img width="100" alt="image" src="https://github.com/shubhranshu-animesh/GSocISM/assets/77923668/b06ece52-4ba0-44ad-b5f3-ab957df656d3">

3. After logging in, students will be directed to the home page shown below, where they will be provided with some basic information about the application and its features, along with a navigation bar and an option to write a new petition.
<img width="100" alt="image" src="https://github.com/shubhranshu-animesh/GSocISM/assets/77923668/dfdd6b88-ee04-4618-b756-7793aa8d18a9">
<img width="100" alt="image" src="https://github.com/shubhranshu-animesh/GSocISM/assets/77923668/3e15dde5-06da-4481-91b2-f8099659ad56">
<img width="100" alt="image" src="https://github.com/shubhranshu-animesh/GSocISM/assets/77923668/d471c9d2-fb31-4642-8392-70408e772854">


4. After clicking upon the ‘write a new petition’ option, students will be directed to the writing space where the user is expected to give a title to the petition and write the content, along with his/her signatory, within a limit of about 400 characters. They will further be redirected to the department section where the user is expected to choose the appropriate department to which they wish to share their grievances with. After submitting the petition, the user sees an animated ‘tick mark’ which confirms that his/her petition has been successfully filed.
<img width="100" alt="image" src="https://github.com/shubhranshu-animesh/GSocISM/assets/77923668/3a34a17e-b83b-4818-ace9-9b14ad0ba2d5">
<img width="100" alt="image" src="https://github.com/shubhranshu-animesh/GSocISM/assets/77923668/3e15dde5-06da-4481-91b2-f8099659ad56">
<img width="100" alt="image" src="https://github.com/shubhranshu-animesh/GSocISM/assets/77923668/9c8836f8-86b8-4e48-86bf-dba8ef51d0fb">
<img width="100" alt="image" src="https://github.com/shubhranshu-animesh/GSocISM/assets/77923668/3e15dde5-06da-4481-91b2-f8099659ad56">
<img width="100" alt="image" src="https://github.com/shubhranshu-animesh/GSocISM/assets/77923668/925b4bfd-8bbb-4b6f-ae6f-d50aff82ca80">

5. The student can check his/her information and activity on the app using the ‘my profile’ feature. It contains basic information about the individual and all the petitions previously submitted by the user. The user will also be able to check the real time status of their grievances/petitions based on the color code.
<img width="100" alt="image" src="https://github.com/shubhranshu-animesh/GSocISM/assets/77923668/6911c77d-e371-4c8a-b692-d11d704091a0">
<img width="100" alt="image" src="https://github.com/shubhranshu-animesh/GSocISM/assets/77923668/c52a594e-88f0-4e18-915d-a75e8c5a39da">
<img width="100" alt="image" src="https://github.com/shubhranshu-animesh/GSocISM/assets/77923668/8a438da9-12a3-45c8-93b8-fc9546e1172f">



6. Then comes the ‘Security Alert’ feature of GSocISM. If and when a student feels unsafe or under some kind of threat then he/she can simply go to the ‘Feeling Unsafe?’ option given in the navigation bar and click upon the ‘SEND ALERT’ button which redirects the individual to his/her institute email-id using which the person can send an SOS to the college authorities and fellow students within seconds . This feature ensures the safety of each and every student on and off campus.
<img width="100" alt="image" src="https://github.com/shubhranshu-animesh/GSocISM/assets/77923668/22b0ec88-8e7d-46e5-ab49-3b782de28aa9">
<img width="100" alt="image" src="https://github.com/shubhranshu-animesh/GSocISM/assets/77923668/baa8730c-89f2-42f5-842b-a167a1c61609">
<img width="100" alt="image" src="https://github.com/shubhranshu-animesh/GSocISM/assets/77923668/e0ed34b2-1dad-42c5-8326-99ef4907f700">



7. Now, for the users who enter as admin: they are allowed to Sign-up/Log In using institute e-mail id with the  “@iitism.ac.in” domain only, which is provided to the college faculty. This sign-in and sign-up feature is enabled using firebase authentication.
<img width="100" alt="image" src="https://github.com/shubhranshu-animesh/GSocISM/assets/77923668/95757830-7801-42a4-b159-3433a1a023a5">
<img width="100" alt="image" src="https://github.com/shubhranshu-animesh/GSocISM/assets/77923668/57980c51-ea32-4607-bfdb-073da163eef4">
<img width="100" alt="image" src="https://github.com/shubhranshu-animesh/GSocISM/assets/77923668/27086c42-7495-49cf-9596-d9f6ede92452">



8. Upon logging in as admin, the user is directed to the home page where he/she can choose the concerned department.
- After selecting their department, the admin is redirected to the page containing all the grievances filed by the students regarding issues relating to that department where he/she is expected to open a petition and declare the status of the petition, based on the decisions taken and implementation of the solution.
- They are given three options for the status of the petition: (PENDING / IN PROGRESS / RESOLVED)
<img width="100" alt="image" src="https://github.com/shubhranshu-animesh/GSocISM/assets/77923668/fe76aab2-cb7d-4e9c-96ac-d035671314c6">
<img width="100" alt="image" src="https://github.com/shubhranshu-animesh/GSocISM/assets/77923668/c675bf3e-fd26-4f4f-961f-ed3ed9d316c1">
<img width="100" alt="image" src="https://github.com/shubhranshu-animesh/GSocISM/assets/77923668/915f3d95-eecf-4132-bf98-962787e4a237">
<img width="100" alt="image" src="https://github.com/shubhranshu-animesh/GSocISM/assets/77923668/28553e80-f32b-42ee-b074-c4bea48b4538">
<img width="100" alt="image" src="https://github.com/shubhranshu-animesh/GSocISM/assets/77923668/e664fe3a-0a50-4c21-9fa4-1576f3a992b5">

  
# Team Details:

- Team Name: fsociety
- Team Member Name & Role:
  1. Garvit Dua (Backend)
  2. Shirsh Garg (Backend)
  3. Shubhranshu Animesh (Frontend)
  4. Utkarsh Prasad (Frontend)
