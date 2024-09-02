FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
            file://v851s.schema \
"

do_install:append() {
    install -Dm 0644 ${WORKDIR}/v851s.schema ${D}${sysconfdir}/usbgx/v851s.schema
}
