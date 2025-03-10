#
# Start up script for USB Gadget DHCP server start application
#
DESCRIPTION = "Application GADGET Ethernet in DHCP server mode start up script for MangoPi MQ T113-S"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI += "file://usb0.sh"
SRC_URI += "file://udhcpd.conf"
SRC_URI += "file://usbgadgetnetdhcp"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${sysconfdir_native}/init.d/
    install -m 0755 ${S}/usb0.sh ${D}${sysconfdir_native}/init.d/
    install -d ${D}${sysconfdir_native}/
    install -m 0755 ${S}/udhcpd.conf ${D}${sysconfdir_native}/
    install -d ${D}${sysconfdir_native}/init.d/
    install -m 0755 ${S}/usbgadgetnetdhcp ${D}${sysconfdir_native}/init.d/
}

# Mark the files which are part of this package
FILES:${PN} += "{sysconfdir_native}/init.d/"
FILES:${PN} += "{sysconfdir_native}/init.d/usb0.sh"
FILES:${PN} += "{sysconfdir_native}/"
FILES:${PN} += "{sysconfdir_native}/init.d/udhcpd.conf"
FILES:${PN} += "{sysconfdir_native}/init.d/"
FILES:${PN} += "{sysconfdir_native}/init.d/usbgadgetnetdhcp"

inherit update-rc.d

INITSCRIPT_NAME = "usbgadgetnetdhcp"
INITSCRIPT_PARAMS = "defaults 99 99"
