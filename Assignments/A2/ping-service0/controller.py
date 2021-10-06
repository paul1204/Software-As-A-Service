import os
from flask import Flask, jsonify, render_template
import random, requests
   
app = Flask(__name__)
   
@app.errorhandler(404 )
def page_not_found(e):
    return '<h1>Page Not Found!</h1>', 404
  
@app.errorhandler(500)
def internal_server_error(e):
    return '<h1>Something is not right on our end!', 500
  
@app.route('/', methods=['GET'])
def index():
    return render_template('index.html')

@app.route('/pong', methods=['GET'])
def pongCall():
    randNum = requests.get('https://pong-service0.herokuapp.com')
    return randNum.text

  
