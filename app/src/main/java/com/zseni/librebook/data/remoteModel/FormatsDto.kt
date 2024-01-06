package com.zseni.librebook.data.remoteModel

import com.google.gson.annotations.SerializedName
import com.zseni.librebook.domain.model.Format

data class FormatsDto(
    @SerializedName("application/epub+zip")
    val applicationEpubZip: String,
    @SerializedName("application/octet-stream")
    val applicationOctetStream: String,
    @SerializedName("application/pdf")
    val applicationPdf: String,
    @SerializedName("application/prs.tex")
    val applicationPrsTex: String,
    @SerializedName("application/rdf+xml")
    val applicationRdfXml: String,
    @SerializedName("application/x-mobipocket-ebook")
    val applicationxmobipocketebook: String,
    @SerializedName("image/jpeg")
    val imageJpeg: String,
    @SerializedName("text/html")
    val textHtml: String,
    @SerializedName("text/html; charset=iso-8859-1")
    val textHtmlCharset: String,
    @SerializedName("text/html; charset=utf-8")
    val textHTMLcharset: String,
    @SerializedName("text/plain; charset=iso-8859-1")
    val textPlain: String,
    @SerializedName("text/plain; charset=us-ascii")
    val textplain: String,
    @SerializedName("text/plain; charset=utf-8")
    val textplaincharset: String
)
fun FormatsDto.toFormat(): Format {
    return Format(
        image = imageJpeg
    )
}