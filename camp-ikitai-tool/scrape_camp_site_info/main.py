import time
from selenium import webdriver
import chromedriver_binary


class Main:
    def __init__(self):
        self.target_url = "https://hinata-spot.me/kanto/saitama/list"

    def process(self):
        # set options
        options = webdriver.ChromeOptions()
        driver = webdriver.Chrome(options=options)

        # Crawling pixiv and save image urls.
        page, url_list = 1, []
        while True:
            driver.get(self.target_url + "?page=" + str(page))
            time.sleep(1)

            if len(driver.find_elements_by_xpath('//span[text()="検索結果がありません。"]')) > 0:
                break
            else:
                # TODO refactor.
                elements = driver.find_elements_by_tag_name("a")
                for element in elements:
                    url = element.get_attribute("href")
                    if "/spots" in url and url not in url_list:
                        url_list.append(url)
                page += 1

        # 詳細ページから情報を取得
        results = []
        for i, url in enumerate(url_list):
            driver.get(url)
            site_name = driver.find_element_by_class_name("name").text
            results.append({"id": i, "site_name": site_name, "address": ""})

        # 結果表示
        print(results)


if __name__ == "__main__":
    main = Main()
    main.process()
