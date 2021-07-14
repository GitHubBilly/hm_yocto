#!/bin/bash

rfkill unblock all
sleep 1
ifconfig wlp4s0 up
sleep 1
wpa_supplicant -Dnl80211 -i wlp4s0 -c /etc/wpa_supplicant.conf -d&
sleep 3
udhcpc -i wlp4s0