$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("./Features/Login.feature");
formatter.feature({
  "line": 1,
  "name": "Login",
  "description": "",
  "id": "login",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Checking login",
  "description": "",
  "id": "login;checking-login",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "Launching browser",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "Opening URL \"https://google.com\"",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "Pagetitle \"\u003cgoogle\u003e\" should be verified",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "close browser",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.launching_browser()"
});
formatter.result({
  "duration": 25876056662,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "https://google.com",
      "offset": 13
    }
  ],
  "location": "Steps.opening_URL(String)"
});
formatter.result({
  "duration": 16425933645,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "\u003cgoogle\u003e",
      "offset": 11
    }
  ],
  "location": "Steps.pagetitle_should_be_verified(String)"
});
formatter.result({
  "duration": 97041046,
  "status": "passed"
});
formatter.match({
  "location": "Steps.close_browser()"
});
formatter.result({
  "duration": 271185711,
  "status": "passed"
});
});