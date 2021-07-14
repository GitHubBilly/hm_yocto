#!/bin/bash

echo 'AT+CGDCONT=1,"IP","internet"' > /dev/ttyUSB1
echo "AT\$QCRMCALL=1,1,3" > /dev/ttyUSB1
sleep 5
udhcpc -i enp0s21f0u1i4
