from flask import Flask, render_template, session, redirect, url_for
from flask_bootstrap import Bootstrap
from flask_moment import Moment
from flask_wtf import FlaskForm
from wtforms import StringField, SubmitField, SelectField
from wtforms.validators import DataRequired, InputRequired, Length


app = Flask(__name__)
app.config['SECRET_KEY'] = 'hard to guess string'

bootstrap = Bootstrap(app)
moment = Moment(app)

@app.errorhandler(404)
def page_not_found(e):
    return render_template('404err.html'), 404

@app.errorhandler(500)
def internal_server_error(e):
    return render_template('500err.html'), 500
"""

@app.route('/', methods=['GET'])
def dropdown():
    options = ['A', 'B', 'C', 'D']
   return render_template('options.html', options=options)

"""
"""
@app.route('/')
def dropdown():
    dropList = ['A', 'B', 'C']
    return render_template('index.html', dropList=dropList)
"""


class NameForm(FlaskForm):
    name = StringField('What is your name? (First, Last)', validators=[DataRequired()])
    studentID = StringField('Enter VID', [InputRequired(), Length(min=9,max=9,message='VID is 9 Digits')])
    email = StringField('Enter Email Address', validators=[DataRequired()])
    #CMSC 425; 4 Characters for Class Type, 1 space, 3 digit number = 8 min and max
    courseID = StringField('Enter The Course Number You Would Like To Join', [InputRequired(), Length(min=8,max=8,message='Enter a Valid ID')])      
    sectionNum = StringField('Enter Section Number', [InputRequired(), Length(min=3,max=3,message='Enter a Valid Section Number')])
    #Course Reference Number
    crn = StringField('Enter Course Reference Numbers', [InputRequired(), Length(min=5,max=5,message='Enter a Valid Course Reference Number')])
    dropList = ['','Desired Section At Capacity', 'Prerequiste Not Satisfied', 'Other']
    s = SelectField('Reason', choices=dropList, default=1)
    
    submit = SubmitField('Submit')



@app.route('/', methods=['GET', 'POST'])
def index():
    form = NameForm()
    if form.validate_on_submit():
        session['name'] = form.name.data
        return redirect(url_for('index'))
    return render_template('index.html', form=form, name=session.get('name'))

