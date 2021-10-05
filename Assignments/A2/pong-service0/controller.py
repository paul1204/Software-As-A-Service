import os
from flask import Flask, jsonify


@app.errorhandler(404)
def page_not_found(e):
    return '<h1>Page Not Found!</h1>', 404


@app.errorhandler(500)
def internal_server_error(e):
    return '<h1>Something is not right on our end!', 500


def genRandomInt():
#    return randrang(0,sys.maxint,3) 
	return jsonify(
	randomNumber= randrang(0,1000,3)
)
