import requests
import pytest

@pytest.fixture
def baseUrl():
    baseURL = "http://127.0.0.1:5000/shuffle/"
    return baseURL


def testShuffle(baseUrl):
    r = requests.get(baseUrl + "1, 2, 3, 4")
    assert(r.json() != "1, 2, 3, 4")

