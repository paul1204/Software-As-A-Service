from flask import Flask, render_template
from flask_bootstrap import Bootstrap
from flask_moment import Moment
from flask_wtf import FlaskForm
from wtforms import StringField, SubmitField
from wtforms.validators import DataRequired

app = Flask(__name__)

#bootstrap = Bootstrap(app)
#moment = Moment(app)

@app.route('/')
def index():
    return render_template('index.html')
