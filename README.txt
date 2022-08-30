The outlines of NLPWeb project:

1. Create a maven project for this NLP web project
2. Add all dependencies to pom.xml, such as coreNLP and it's models, Sprint boots and it's plugins
3. Create a console application for part I
4. Add Bootstrap framework to the project, create web pages for demonstrating the analysis result.
5. Create RESTFul web api for frontend
6. Use jquery ajax to retrieve the analysis result

For part1: run NLPMain.java,the standard input is the name of the file you want parse. Just enter "text.txt"(a test file in this repo),and then enter any name you prefer for the ouput file. The analysis result will printed out on the console and also saved as a file in json format.
There is a util class "NLPUtils.java" for easy use of other people in this project.Some basic functions of coreNLP can be used directly using this class.
AnalysisResult.java is the result object for returning of POST action of spring boot.IndexController.java and ApiController.java is the controller of spring boot mvc.



For part2: run NLPWebApplication.java. Open a local web browser and enter web address: localhost:8080. 
The html files are located on src/main/resources/templates
bootstrap is used for easy developing of the navigation bar of the web page.
ajex and jquery is used for retrieve the user input and check validation and then make the POST action.
