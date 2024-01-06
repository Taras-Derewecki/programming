url:
http://127.0.0.1:8000/restaurant/
http://127.0.0.1:8000/restaurant/home
http://127.0.0.1:8000/restaurant/menu/
http://127.0.0.1:8000/restaurant/menu/1
http://127.0.0.1:8000/restaurant/booking/
http://127.0.0.1:8000/api-token-auth/
http://127.0.0.1:8000/auth/users/
http://127.0.0.1:8000/auth/token/login/
http://127.0.0.1:8000/auth/token/logout/


for test_views.py:
class MenuItemView(generics.ListCreateAPIView):
    # comment permission_classes for test_views
    # permission_classes = [IsAuthenticated]
    queryset = Menu.objects.all()
    serializer_class = MenuSerializer
  