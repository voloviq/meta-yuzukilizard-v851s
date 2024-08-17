DESCRIPTION = "Resize Rootfs systemd service"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "\
	file://resize-rootfs.init \
	file://resize-rootfs \
"
RDEPENDS_${PN} = "e2fsprogs-resize2fs parted "

do_install () {
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/resize-rootfs.init ${D}${bindir}/resize-rootfs
    install -d ${D}${sysconfdir_native}/init.d/
    install -m 0755 ${WORKDIR}/resize-rootfs ${D}${sysconfdir_native}/init.d/
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

# Mark the files which are part of this package
FILES:${PN} += "${bindir}/resize-rootfs/resize-rootfs.init"
FILES:${PN} += "resize-rootfs.init"
FILES:${PN} += "${sysconfdir_native}/init.d/resize-rootfs"
FILES:${PN} += "resize-rootfs"

inherit update-rc.d

INITSCRIPT_NAME = "resize-rootfs"
INITSCRIPT_PARAMS = "start 10 S ."