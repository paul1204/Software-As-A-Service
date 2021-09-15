from flask import Flask, render_template, session, redirect, url_for
from flask_bootstrap import Bootstrap
from flask_moment import Moment
from flask_wtf import FlaskForm
from wtforms import StringField, SubmitField
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


class NameForm(FlaskForm):
    name = StringField('What is your name? (First, Last)', validators=[DataRequired()])
    studentID = StringField('Enter VID', [InputRequired(), Length(min=9,max=9,message='VID is 9 Digits')])
    courseID = StringField('Enter The Course Number You Would Like To Join', [InputRequired(), Length(min=10,max=10,message='Enter a valid ID')])      

    submit = SubmitField('Submit')



@app.route('/', methods=['GET', 'POST'])
def index():
    form = NameForm()
    if form.validate_on_submit():
        session['name'] = form.name.data
        return redirect(url_for('index'))
    return render_template('index.html', form=form, name=session.get('name'))

