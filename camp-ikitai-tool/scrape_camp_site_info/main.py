from lib2to3.pgen2 import driver
from selenium import webdriver
from selenium.webdriver.chrome.options import Options


driver = None


def create_driver():
    options = Options()
    driver = webdriver.Chrome(options=options, executable_path="./chromedriver")
    return driver


def scrape():
    global driver
    if driver is None:
        driver = create_driver()

    driver.get("https://hinata-spot.me/kanto/saitama/list")

    atag_list = driver.find_elements_by_partial_link_text("a")
    for atag in atag_list:
        print(atag.get_attribute("href"))


if __name__ == "__main__":
    scrape()
