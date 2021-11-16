import os
from flask import Flask, jsonify
import random, requests
from flask_httpauth import HTTPDigestAuth
import json

# sudo chmod 666 /var/run/docker.sock

app = Flask(__name__)
app.config['SECRET_KEY'] = 'super secret'

{
    "list_of_ints": [0,375,668,5,8]
}

l0 = [1,2,3,4,5]
#jsonL = json.dumps(l)

@app.errorhandler(404)
def page_not_found(e):
    return '<h1>Page Not Found!</h1>', 404

@app.errorhandler(500)
def internal_server_error(e):
    return '<h1>Something is not right on our end!', 500

@app.route('/', methods=['GET'])
def index():
    return '<h1>Use /shuffle/"1,2,3" endpoint to shuffle "1,2,3"</h1>'

@app.route('/shuffle', methods=['GET'])
def index2():
    return '<h1>To shuffle a list, add /"1,2,3,4,5" to the end of the URL</h1>'


@app.route('/shuffle/<list_of_ints>', methods=['GET'])
def shuffle (list_of_ints):
    
    l = list_of_ints.split(",")
    random.shuffle(l)
    shuffled_list = json.dumps(l)
    return (shuffled_list)

    #json_list = requests.get_json('list_of_ints')
    #random.shuffle(json_list)

    #mockList = {'list_of': [1,2,3,4]}
   # shuf = response.json()

    #return (shuffled_list)

if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0')