FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "\
    file://ecm \
"

do_install:append() {
    # ecm function (enable before nfsroot)
    install -m 0755 ${WORKDIR}/ecm ${D}/init.d/83-ecm
}

PACKAGES += "\
    initramfs-module-ecm \
"

SUMMARY_initramfs-module-ecm = "enable USB ethernet function in initramfs"
RDEPENDS_initramfs-module-ecm = "${PN}-base"
FILES_initramfs-module-ecm = "/init.d/83-ecm"
