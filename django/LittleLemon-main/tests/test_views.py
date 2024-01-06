from django.test import TestCase
from django.urls import reverse
from rest_framework import status
from rest_framework.test import APIClient
from restaurant.models import Menu
from restaurant.serializers import MenuSerializer

class MenuViewTest(TestCase):
    def setUp(self):
        # Add test instances of the Menu model
        self.menu_item1 = Menu.objects.create(title='Item 1', price=10.99, inventory=20)
        self.menu_item2 = Menu.objects.create(title='Item 2', price=15.99, inventory=15)

    def test_getall(self):
        # Retrieve all Menu objects added for the test purpose
        url = reverse('menu')
        client = APIClient()
        response = client.get(url)

        # Check if the request was successful (HTTP 200 OK)
        self.assertEqual(response.status_code, status.HTTP_200_OK)

        # Serialize the test instances
        serialized_data = MenuSerializer([self.menu_item1, self.menu_item2], many=True).data

        # Check if the serialized data in the response is equal to the expected data
        self.assertEqual(response.data, serialized_data)
