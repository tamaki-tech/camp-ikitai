# -*- coding:utf-8 -*-

import subprocess
from django.core.management.base import BaseCommand


class Command(BaseCommand):
    def handle(self, *args, **options):
        # start docker
        # TODO すでにコンテナ起動してたら落として再作成する？
        subprocess.call("docker-compose up -d", shell=True)

        # run migrate
        subprocess.call("python manage.py makemigrations", shell=True)
        subprocess.call("python manage.py migrate", shell=True)

        # TODO 初期データ投入
