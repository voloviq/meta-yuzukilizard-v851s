SUMMARY = "small linux bootloader for Allwinner T113-S3"
HOMEPAGE = "https://github.com/szemzoa/awboot"

PROVIDES = "virtual/bootloader"
DEPENDS += "awboot-tools-native gcc-arm-none-eabi-native"

require awboot-common.inc
inherit deploy

SRC_URI += " \
    file://v851s-uart0.patch \
"

AWBOOT_BINARY = "awboot-boot-sd.bin"

do_compile() {
    oe_runmake -C ${S} O=${B}
}

do_install(){
    install -D -m 644 ${B}/${AWBOOT_BINARY} ${D}/boot/${AWBOOT_BINARY}
}

do_deploy() {
    install -D -m 644 ${B}/${AWBOOT_BINARY} ${DEPLOYDIR}/${AWBOOT_BINARY}-${PV}-${PR}
    cd ${DEPLOYDIR}
    ln -sf ${AWBOOT_BINARY}-${PV}-${PR} ${AWBOOT_BINARY}
}

FILES:${PN} = "/boot"
FILES:${PN} += "/boot/awboot-boot-sd.bin"

addtask deploy before do_build after do_compile
