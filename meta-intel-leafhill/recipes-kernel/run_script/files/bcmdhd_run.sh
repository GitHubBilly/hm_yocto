#!/bin/bash

rfkill unblock all
sleep 2
sudo modprobe cfg80211
sleep 1
rmmod /lib/firmware/bcmdhd/bcmdhd.ko
insmod /lib/firmware/bcmdhd/bcmdhd.ko "firmware_path=/lib/firmware/bcmdhd/fw_bcm43752a2_pcie_ag.bin nvram_path=/lib/firmware/bcmdhd/nvram_ap6275p.txt"
sleep 2
ifconfig wlan0 up
sleep 2
wpa_supplicant -Dnl80211 -i wlan0 -c  /etc/wpa_supplicant.conf -d&
sleep 3
udhcpc -i wlan0