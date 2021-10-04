import requests
from requests.auth import HTTPDigestAuth
import random

url = 'http://127.0.0.1:5000/'
r = requests.get(url + 'users', auth=HTTPDigestAuth('john', 'hello'))
print(r.text)

users = r.json()['users']
u = random.choice(users)
new_u = u['username'] + str(random.randint(1,10))
print(new_u)

r = requests.post(url + 'user', json={'username':new_u}, auth=HTTPDigestAuth('john', 'hello'))
assert(r.status_code == 201)
