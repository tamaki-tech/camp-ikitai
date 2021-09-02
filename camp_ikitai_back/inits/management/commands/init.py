# -*- coding:utf-8 -*-

import subprocess
from django.core.management.base import BaseCommand


class Command(BaseCommand):
    def handle(self, *args, **options):
        # start docker
        subprocess.call("docker-compose down", shell=True)
        subprocess.call("docker-compose up -d", shell=True)

        # sleep
        subprocess.call("sleep 3", shell=True)

        # add records
        subprocess.call("python manage.py makemigration", shell=True)
        subprocess.call("python manage.py migrate", shell=True)
