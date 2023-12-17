from django.urls import path
from .views import MenuItemListView, MenuItemDetailView

urlpatterns = [
    path('menu/', MenuItemListView.as_view(), name='menu_list'),
    path('menu/<int:pk>/', MenuItemDetailView.as_view(), name='menu_detail'),
]
