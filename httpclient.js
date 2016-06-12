"use strict";
var http = require("http");
var util = require("util");

http.get("http://www.google.co.jp/", function(res){
  //console.log("Got response:"+ util.inspect(res,{showHidden: true, depth : null,colors: true}));
  console.log("Headers\r\n" + util.inspect(res.headers,{showHidden: true, depth : null,colors: true}));
  console.log("StatusCode\r\n" + res.statusCode);
  res.resume();
  res.on("data", function(chunk){
    console.log("Body \r\n" + chunk);
  });
}).on("error", function(e){
  console.log("Got Error! " + e.message);
});
