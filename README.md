Project 1

Holden Hankins
Treyford Mercer

Project takes a user input, attempts to find a Wikipedia article for that input, gets a JSON for that file's data, and gives last 15 revisions from newest to oldest

WikiURLBuilder - plugs input into premade URL string to connect to API
WikiClient - connects to API
GetJson - gets the json file as a string
JsonParser - parses the string, information stored in WikiArticle and WikiEdit
WikiEdit & WikiArticle also contain print methods for data
Time and Date - verify validity of both fields to detect corrupted data
GetWikiEditHistoryTerminal - main() method
GetWikiEditHistoryGUI& Controller - run GUI varient
