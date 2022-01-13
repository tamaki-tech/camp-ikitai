import time
from selenium import webdriver
import pandas as pd
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

            # サイト名
            site_name = driver.find_element_by_class_name("name").text

            # 概要文章
            addition = driver.find_element_by_class_name("catchPhrase").text

            # 住所
            elements = driver.find_elements_by_class_name("text")
            address = ""
            for element in elements:
                if "〒" in element.text:
                    address = element.text

            # 電話番号
            phone_number = driver.find_element_by_class_name("tel").text

            results.append(
                {
                    "id": i,
                    "site_type_id": 1,
                    "site_name": site_name,
                    "addition": addition,
                    "address": address,
                    "prefecture": "埼玉",
                    "access": "",
                    "phone_number": phone_number,
                    "url": "",
                    "price": "",
                    "image_path": "",
                    "latitude": 0,
                    "longitude": 0,
                }
            )

        df = pd.io.json.json_normalize(results)
        df.to_csv("camp_site.csv", index=False)


if __name__ == "__main__":
    main = Main()
    main.process()
